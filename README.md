"# todo-nudge" 
## 1. profile
### 1.1`self`
#### 1.1.1 register slack token
```
$ mkdir slack
$ touch slack/slack_key
```
##### write token in slack/slack_key

### 1.2 `prod`
#### 1.2.1 make directory
```
$ mkdir ${home}/.nudge
$ mkdir ${home}/.nudge/db
$ mkdir ${home}/.nudge/logs
```
#### 1.2.2 register slack token
```
$ touch ${home}/.nudge/slack_key
```
##### write token in ${home}/.nudge/slack_key
## 2. run
```
java -Dspring.profiles.active=${prod/self} -jar nudge.jar
```