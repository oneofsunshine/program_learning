/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * ans = NULL, *last = NULL;
        int up = 0;
        while (NULL != l1 && NULL != l2) {
            int tmp = l1->val + l2->val + up;
            up = tmp / 10;
            //第一个单独处理
            if (NULL == last) {
                ans = new ListNode(tmp % 10);
                last = ans;
            } else
                last = pushBack(last, tmp % 10);
            l1 = l1->next;
            l2 = l2->next;
        }
        while (NULL != l1) {
            int tmp = l1->val + up;
            last = pushBack(last, tmp % 10);
            up = tmp / 10;
            l1 = l1->next;
        }
        while (NULL != l2) {
            int tmp = l2->val + up;
            last = pushBack(last, tmp % 10);
            up = tmp / 10;
            l2 = l2->next;
        }
        if (0 != up) {
            ListNode * l = new ListNode(up);
            last->next = l;
        }
        return ans;
    }
    //在末尾添加值val，返回链表尾
    ListNode * pushBack(ListNode * last, int val) {
        ListNode * l = new ListNode(val);
        last->next = l;
        return l;
    }
    
};
