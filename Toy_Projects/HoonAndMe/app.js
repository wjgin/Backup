class App {
    constructor() {
        // html에 canvas 태그와 그 안에 2d drawing context를 만든다.
        this.canvas = document.createElement('canvas');
        this.ctx = this.canvas.getContext('2d');
        document.body.appendChild(this.canvas);

        // ***constructor가 정의되는 순간 함수 실행***
        //    window.onload시 바로 실행되는 함수가 된다.
        this.drawBall();
    }

    // 함수 정의(원 생성)
    drawBall() {
        this.ctx.beginPath();
        this.ctx.arc(100, 100, 50, 0, Math.PI * 2);
        this.ctx.fillStyle = "rgb(200, 0, 0)";
        this.ctx.fill();
        this.ctx.closePath();
    }
}

// window.onloade를 사용하는 방법
window.onload = () => {
    
    // ***window를 load하는 순간 App class의 constructor를 생성***
    new App();
    //const app = new App();
    //app.drawBall();
}
