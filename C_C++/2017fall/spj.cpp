#include <stdio.h>
#include <math.h>
#define AC 0
#define WA 1
#define ERROR -1

int spj(FILE *input, FILE *user_output);

void close_file(FILE *f){
    if(f != NULL){
        fclose(f);
    }
}

int main(int argc, char *args[]){
    FILE *input = NULL, *user_output = NULL;
    int result;
    if(argc != 3){
        printf("Usage: spj x.in x.out\n");
        return ERROR;
    }
    input = fopen(args[1], "r");
    user_output = fopen(args[2], "r");
    if(input == NULL || user_output == NULL){
        printf("Failed to open output file\n");
        close_file(input);
        close_file(user_output);
        return ERROR;
    }

    result = spj(input, user_output);
    printf("result: %d\n", result);
    
    close_file(input);
    close_file(user_output);
    return result;
}

int spj(FILE *input, FILE *user_output){
    int n=0;
    int i = 0;
    int j = 0;
    float nums[100][2];
    float distance = 0;
    float user_dis;
    float temp_distance = 0;
    if(fscanf(input, "%d", &n) == EOF)
        return ERROR;
    for (i = 0; i < n; i++)
        if(fscanf(input, "%f %f", &nums[i][0], &nums[i][1]) == EOF)
            return ERROR;
    for (i = 0; i < n; i++) {
        for (j = i; j < n; j++) {
            if (i != j)
                temp_distance = sqrt(pow(nums[i][0] - nums[j][0], 2) + pow(nums[i][1] - nums[j][1], 2));
            if (distance < temp_distance)
                distance = temp_distance;
        }
    }
    if(fscanf(user_output, "%f", &user_dis) == EOF)
        return ERROR;
    if(fabs(distance - user_dis) > 0.0005)
        return WA;
    return AC;
}
