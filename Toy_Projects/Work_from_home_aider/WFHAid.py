import keyboard
import pyautogui
from tkinter import *   # tkinter 라이브러리 전체 import

x, y = pyautogui.position()

clicked = False

# 마우스 이동 함수 정의
def moveMouse():
    movingTime = int(ent_time.get()) # 입력 창의 값 추출
    while(clicked):
        pyautogui.moveRel(500, 0, movingTime)
        pyautogui.moveRel(-500, 0, movingTime)




# Tk 함수(창 생성) 정의
win = Tk()
# 창크기 설정
win.geometry("300x300")
# 창 타이틀 변경
win.title("화면 꺼짐 방지")
# 전체 폰트 변경
win.option_add("*Font", "맑은고딕 15")

# 실행 시간 입력창
ent_time = Entry(win)
ent_time.config(width=10)
ent_time.grid(column=0, row=0)

# 주기 라벨
lab_start = Label(win)
lab_start.config(text = "초 마다 실행")
lab_start.grid(column=1, row=0)

# 실행 버튼 정의
btn_start = Button(win) # 버튼 생성0
btn_start.config(text = "실행(F9)") # 버튼 이름
btn_start.config(command = moveMouse) # 클릭시 함수 실행
btn_start.grid(column=0, row=1) # 버튼 배치

# 정지 버튼 정의
btn_end = Button(win) # 버튼 생성
btn_end.config(text = "중지(F10)") # 버튼 이름
#btn_end.config(command = stopMove) # 클릭시 함수 실행
btn_end.grid(column=1, row=1) # 버튼 배치


# 창 실행
win.mainloop()