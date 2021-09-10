let text = "I am JavaScript sam";
let textContent = document.getElementById('text');
let textChangeButton = document.getElementById('textChangeButton');
textContent.innerHTML = text;



function showLength() {
    document.getElementById('length').innerHTML = text.length;
}

function askIndexOf() {
    let pos = prompt("찾은 단어를 입력하세요.")
    let result = text.indexOf(pos)
    if (result == -1) {
        document.getElementById('indexOf').innerHTML = "결과가 없어요...😫"
    } else {

        document.getElementById('indexOf').innerHTML = result;
    }
}


function askLastIndexOf() {
    let pos = prompt("찾은 단어를 입력하세요.(뒤에서부터 찾아요.)")
    let result = text.lastIndexOf(pos)
    if (result == -1) {
        document.getElementById('lastIndexOf').innerHTML = "결과가 없어요...😫"
    } else {

        document.getElementById('lastIndexOf').innerHTML = result;
    }
}

function askSubstr() {
    let start = Number(prompt("시작 index"));
    let end = Number(prompt("끝 index"));
    let result = text.substr(start, end + 1);
    console.log(result);
    if (start < 0 || end >= text.length) {
        document.getElementById('substr').innerHTML = '범위를 넘어가요...😫';
    } else if (isNaN(start) || isNaN(end)) {
        document.getElementById('substr').innerHTML = "숫자만 입력해주세요...😯";
    } else {
        document.getElementById('substr').innerHTML = result;
    }
}

function changeText() {
    text = prompt("바꿀 문자를 입력해주세요.");
    textContent.innerHTML = text;
}

function devilRun() {
    document.write("<canvas id = 'myCanvas'></canvas>");
    let canvas = document.getElementById('myCanvas');
    let ctx = canvas.getContext('2d');
    let fontSize = '50px';
    canvas.style.width = window.innerWidth;
    canvas.style.height = window.innerHeight;
    ctx.font = fontSize + ' serif';
    canvas.style.border = '1px solid black';

    let x = canvas.width / 2;
    let y = canvas.height / 2;
    let dx = 2;
    let dy = 2;

    // 실행
    setInterval(draw, 10);

    // 그리기
    function draw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.fillText("😈", x, y);

        // 벽 충돌 시
        if (x + dx > canvas.width - 50 || x + dx < -20) dx = -dx;
        else if ((y + dy > canvas.height) || (y + dy < 50)) dy = -dy;

        // 윈도우, 텍스트 위치 재구성
        canvas.style.width = window.innerWidth;
        canvas.style.height = window.innerHeight;
        x += dx;
        y += dy;
    }

}



textChangeButton.addEventListener('mouseout', (event) => {
    event.innerHTML = '이벤트 확인';
    document.getElementById('textCursor').style.display = 'none';
})
textChangeButton.addEventListener('mouseover', (event) => {
    event.innerHTML = '이벤트 확인';
    document.getElementById('textCursor').style.display = 'inline';
})