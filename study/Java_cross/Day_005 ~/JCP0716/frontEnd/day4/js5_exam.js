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
    document.write("😈");
    document.body.style.fontSize = 300;
    document.body.style.display = 'flex';
    document.body.style.justifyContent = 'center';
    document.body.style.alignItems = 'center';

}



textChangeButton.addEventListener('mouseout', (event)=> {
    event.innerHTML = '이벤트 확인';
    document.getElementById('textCursor').style.display = 'none';
})
textChangeButton.addEventListener('mouseover', (event)=> {
    event.innerHTML = '이벤트 확인';
    document.getElementById('textCursor').style.display = 'inline';
})