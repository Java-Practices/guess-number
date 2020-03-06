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

第六次输入：9864
输出：
1234 0A1B
1235 0A0B
1264 0A2B
1764 0A2B
1864 0A3B
1866 Wrong input
9864 0A4B
Unfortunately, you have no chance, the answer is 4689!

```

