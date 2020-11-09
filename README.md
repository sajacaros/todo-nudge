"# todo-nudge" 
## 1. profile `self`
#### 1.1 register slack token
```
$ mkdir slack
$ touch slack/slack_key
```
##### 1.1.1 write token in slack/slack_key

## 2. profile `prod`
#### 2.1 make directory
```
$ mkdir ${home}/.nudge
$ mkdir ${home}/.nudge/db
$ mkdir ${home}/.nudge/logs
```
#### 2.2 register slack token
```
$ touch ${home}/.nudge/slack_key
```
##### 2.2.1 write token in ${home}/.nudge/slack_key
## 3. run
```
java -Dspring.profiles.active={prod/self} -jar nudge.jar
```