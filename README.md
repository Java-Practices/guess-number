# Guess Number Game（猜数字小游戏）

## 需求描述：
实现猜数字的游戏。游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样。你有6次猜测的机会，如果猜对则获胜， 否则失败。每次猜测时需依序输入4个数字，程序会根据猜测的情况给出xAxB的反馈：

* A前面的数字代表：数字和位置都对的个数
* B前面的数字代表：数字对但是位置不对的个数

### 举例说明：
如果这四个格子里面的数字为：1234，那么对于以下输入，相应有以下输出：

| Input | Output | Instruction|
| ------ | ------ | ------|
| 1567	| 1A0B	| 1 correct |
| 2478	| 0A2B	| 2 and 4 wrong position |
| 0324	| 1A2B	| 4 correct，2 and 3 wrong position |
| 5678	| 0A0B	| all wrong |
| 4321	| 0A4B	| 4 numbers position wrong |
| 1234	| 4A0B	| win, all correct |
| 1123	| Wrong   | input	Wrong input, input again |
| 12	| Wrong   | input	Wrong input, input again |

#### 需要注意一下几点：

* 答案在游戏开始时先尝试从文件(answer.txt)读入答案，如果文件不存在或者文件中的答案格式不正确，则随机生成。
* 在每次猜测时，程序应给出当前猜测的结果，以及之前所有猜测的数字和结果以供玩家参考。
* 如果在6次之内猜对，则输出“Congratulations, you win!”，然后结束游戏。
* 如果6次均未猜中，则输出“Unfortunately, you have no chance, the answer is 1234!”。
* “Wrong input“不计入猜测次数。

### 测试样例

```
假设答案为：4689

第一次输入：1234
输出：
1234 0A1B

第二次输入：1235
输出：
1234 0A1B
1235 0A0B

第三次输入：1264
输出：
1234 0A1B
1235 0A0B
1264 0A2B

第四次输入：1764
输出：
1234 0A1B
1235 0A0B
1264 0A2B
1764 0A2B

第五次输入：1864
输出：
1234 0A1B
1235 0A0B
1264 0A2B
1764 0A2B
1864 0A3B

错误输入：1866， 不计入总次数
1866 Wrong input

第六次输入：9864
输出：
1234 0A1B
1235 0A0B
1264 0A2B
1764 0A2B
1864 0A3B
9864 0A4B
Unfortunately, you have no chance, the answer is 4689!

```

## 项目说明
#### 1. 文件及文件夹说明：

* **src/test:** 该文件夹为测试所在文件夹，里面包含了项目的所有单元测试的文件。

* **src/mian：** 该文件为源码所在文件，里面是该应用程序的所有源代码。

* **src/main/java/App.java:** 该文件为该应用程序的启动文件。

* **requirement.md:** 该文件提供了为完成该程序所需要的所有知识点以及相关学习资料。

* **src/main/resources/answer.txt** 该文件给此游戏的配置文件，里面包含了该数字的正确答案。


#### 2. 分支说明： 

* **master:** 该分支为未实现分支，主要包括了所有测试和部分已实现的脚手架代码，您需要基于此分支进行开发。

* **answer:** 该分支已经实现了该游戏，源代码全部包含在src/mian文件夹中，如果您在master分支上面实现功能时遇到了困难，您可以切换到该分支上面进行参考。

## 你该怎么做？

#### 1. 将本项目clone到您的本地：
```bash
git clone https://gitlab.com/tw-baseline-exam/guess-number.git
```
#### 2. 安装JDK8，并配置Java开发环境：
```bash
java -version
java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)
```
#### 3. 下载并安装[IntelliJ IDEA](https://www.jetbrains.com/idea/download)
#### 4. 使用IntelliJ IDEA进行开发
用该编辑器打开此项目，可以自动导入相关的依赖，基于此进行开发。
* 可以使用IntelliJ IDEA去运行单个测试。
* 可以使用IntelliJ IDEA来启动项目，进行本地测试。
```bash
App.java -> run main method
```


## [Gradle](https://gradle.org/)使用说明：
本项目使用Gradle来管理相关的依赖，下面是一些您可能在此过程中用到的命令：
说明：下面的命令需要在项目的根目录下面执行：
#### 1. 跳过测试构建项目并引入相关依赖：
```bash
./gradlew clean build -x test
```
#### 2. 构建项目(不跳过测试)
```bash
./gradlew clean build
```
#### 3. 执行该项目的所有测试：
```bash
./gradlew test
```
#### 4. 用gradle运行该游戏：
```bash
./gradlew run
```

## 其他说明：
#### 1. 完成该程序的顺序是什么？从哪里下手？
以我个人的经验，我推荐您以下面的顺序逐个完成(主要完成加了注释Need to be implement的部分)，完成一个文件后，运行该文件的测试，使得测试逐个通过：
* src/main/java/answer/Answer.java
* src/main/java/game/GuessResult.java
* src/main/java/game/Game.java

#### 2.如果自己还不具备完成该程序的知识，哪里可以学习？
由于学员水平不一，如果您觉得自己能够完成所有的功能，那就最好了，直接开干就行了！如果您发现自己有些代码看不明白或者是某个知识点不清楚，您可以以[requirement.md](https://gitlab.com/tw-baseline-exam/guess-number/-/blob/master/requirement.md)列举的知识点和材料进行学习，加油哦！

