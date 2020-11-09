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

## 3. api
### create todo
```
api : /todo
method : post
header : content-type, accept : application/json
body : 
{
    "targetDate": "20/11/27",
    "channel": "slack channel",
    "todo": "todo"
}
response : Long id
```
### find todo on the date
```
api : /todo?date=yy/MM/dd
method : get
header : accept : application/json
response : 
[{
    "id":64,
    "targetDate":"yy/MM/dd",
    "channel":"channel",
    "todo":"todo",
    "registerDate":"yy/MM/dd HH:mm:ss"}
, ...]
```
### notify today todos
```
api : /todo/today
method : post
header : content-type,accept : application/json
response : 
```