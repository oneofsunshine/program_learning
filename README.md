program learning 
mess

```
配置环境
git config --global user.name "oneofsunshine"！！！！
git config --global user.email "863958701@qq.com"！！！！
git config --list 检查设置
ssh-keygen -t rsa -C "863958701@qq.com"！！！！
ssh -T git@github.com！！！
```
**初始化** git init  
**创建hello.md文件** echo "这是一次测试test ssh key" > hello.md  
**提交到本地** 若出现如上warning提示则重新提交一次即可  
**`git add .`**   #提交当前目录下所有文件    
**提交到github** `git commit -m "add hello.md"`   #提交记录说明   
`git remote add origin ‘粘贴复制test ssh key的ssh路径’`  
`git push -u origin master` #第一次提交加参数-u  
！！！解决failed to push some refs to git！！！  
`git pull --rebase origin master`    
也可以试试clone下来

---

**远程删除** 
```
git rm file
git commit -m "rm file"
git push
```

---

### 分支
**删除远程分支** `git push origin :branchName`  
**删除本地分支** `git branch -d branchName`  
**创建分支** `git branch branchName`  
**切换分支** `git checkout branch_name`  
**提交分支**   
`git commit -a -m "my new branch"`  
`git push origin branchName:branchName`  
**把本地的某个分支作为远程master分支** `git push origin branch:master`  
**将分支合并到当前分支** `git merge branchName`  
~~**标记tag** `git tag tagName`~~
