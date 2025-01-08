# GTA5Helper
Help user to AFK in FiveM RedDevil server.

Written in June, 2022.

想要在紅惡魔掛機可能會發生三種情況:
1. 跳出掛機警示: 提示會要求你在特定時間內按某個隨機1~9數字按鍵，來解除警示，否則會斷線
2. 可能會生病，總共四種病，不及時治療會死亡
3. 需要定時吃飯，否則會餓死

主要方法:
- 使用Tesseract OCR、OpenCV辨識文字、圖片，用來偵測當前有無發生情況
- 將需要處理的三種情況當作task，使用thread pool定期分派，當作背景程式處理
- 使用Synchronized處理thread之間同步問題
---

![image](Resource/img/e5.jpg)
![image](Resource/img/1920_1080_感冒_aaa_ccc.png)

