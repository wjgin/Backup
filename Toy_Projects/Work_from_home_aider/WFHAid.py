import keyboard
import time
import pyautogui
from tkinter import *   # tkinter 라이브러리 전체 import

# Tk 함수(창 생성) 정의
win = Tk()

# 마우스 이동 함수 정의
def moveMouse():
    #sleepTime = int(ent_time.get()) # 입력 창의 값 추출 
    initX, initY = pyautogui.position() # 초기 마우스 위치
    dx = 20 # x축 이동 최소 단위
    # 마우스 움직임의 시작
    while True:
        pyautogui.moveRel(dx, 0, 0.05)   # 시작 위치에서 dx만큼 이동
        curX, curY = pyautogui.position()   # 현재 위치(x축으로 이동)
        # x가 초기 값에 일정거리가 지나면 방향 변경
        if(curX > initX + 200 or curX < initX):
            dx = -dx
        # y 위치가 바뀌면 초기값 재 설정 (마우스 수동 이동 시)
        if(curY != initY):
            initX, initY = pyautogui.position()
        # 탈출키
        if(keyboard.is_pressed('Esc')):
            break
    
    # 처음 동작 코드
    '''
        while True:
        pyautogui.moveRel(100, 0, 0.5)
        time.sleep(sleepTime)
        
        if(keyboard.is_pressed('Esc')):
            break
        
        pyautogui.moveRel(-100, 0, 0.5)
        time.sleep(sleepTime)

        if(keyboard.is_pressed('Esc')):
            break
            '''

# 창크기 설정
win.geometry("500x200-600+400")
# 창 타이틀 변경
win.title("화면 꺼짐 방지")
# 전체 폰트 변경
win.option_add("*Font", "맑은고딕 15")

'''
# 실행 시간 입력창
ent_time = Entry(win)
ent_time.config(width=10)
ent_time.grid(column=0, row=0)
'''

# 실행 기능 설명 라벨
lab_start = Label(win)
lab_start.config(text = "실행 버튼을 누르면 마우스가 움직입니다.")
lab_start.place(x = 15, y = 30)

# 종료 기능 설명 라벨
lab_start = Label(win)
lab_start.config(text = "ESC 키를 누르면 움직임을 종료 합니다.")
lab_start.place(x = 20, y = 130)

# 실행 버튼 정의
btn_start = Button(win) # 버튼 생성0
btn_start.config(text = "실행(F9)") # 버튼 이름
btn_start.config(command = moveMouse) # 클릭시 함수 실행
btn_start.place(x = 50, y = 70) # 버튼 배치

# 종료 버튼 정의
btn_end = Button(win) # 버튼 생성
btn_end.config(text = "종료(ESC)") # 버튼 이름
btn_end.place(x = 300, y = 70) # 버튼 배치

# 키보드로 실행
keyboard.add_hotkey("F9", moveMouse)

# 창 실행
win.mainloop()