function interact() {
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext('2d');
    var x = canvas.width / 2;
    var y = canvas.height - 60; // paddle 높이보다 위에서 시작
    var dx = 2;
    var dy = -2;
    var ballRadius = 10;
    var speed = 10;
    var score = 0;

    //paddle
    var paddleHeight = 25;
    var paddleWidth = 75;
    var paddleX = (canvas.width - paddleWidth) / 2; // paddle x 시작점
    var paddleY = canvas.height - paddleHeight-10;
    
    //paddleMoving
    var rightPressed = false;
    var leftPressed = false;
    var rocketShoot = false;
    
    //brick
    var brickRowCount = 3;
    var brickColumnCount = 6;
    var brickWidth = 80;
    var brickHeight = 20;
    var brickPadding = 10;
    var brickOffsetTop = 30;
    var brickOffsetLeft = 30;

    //Rocket
    var rocketWidth = 10;
    var rocketHeight = 30;
    var rocketLeftX = paddleX;
    var rocketRigthX = paddleX + paddleWidth - rocketWidth;
    var rocketY = paddleY - rocketHeight;
    var rocketSpeed = -4;

    // brick 정의
    var bricks = [];
    for (var c = 0; c < brickColumnCount; c++) {
        bricks[c] = [];
        for (var r = 0; r < brickRowCount; r++) {
            bricks[c][r] = { x: 0, y: 0, status: 1 };
        }
    }

    document.addEventListener("keydown", keyDownHandler, false);
    document.addEventListener("keyup", keyUpHandler, false);
    document.addEventListener("keydown", rocketKeyHandler, false);

    function drawRocket(){
        ctx.beginPath();
        ctx.fillStyle = "rgb(0, 0, 200)";
        ctx.fillRect(rocketLeftX, rocketY, rocketWidth, rocketHeight);
        ctx.moveTo(rocketRigthX, rocketY);
        ctx.fillRect(rocketRigthX, rocketY, rocketWidth, rocketHeight);
        ctx.closePath();
    }

    // 방향키
    function keyDownHandler(e) {
        console.log(e.keyCode);
        if (e.keyCode == 39) {
            rightPressed = true;
        } else if (e.keyCode == 37) {
            leftPressed = true;
        } else if (e.keyCode == 70) {
            rocketShoot = true;
        }
    }

    function keyUpHandler(e) {
        if (e.keyCode == 39) {
            rightPressed = false;
        } else if (e.keyCode == 37) {
            leftPressed = false;
        }
    }

    // 미사일 발사
    function rocketKeyHandler(e){
        if(e.keyCode == 70) {
            rocketShoot = true;
        }
    }
    function collisionDetection() {
        for (var c = 0; c < brickColumnCount; c++) {
            for (var r = 0; r < brickRowCount; r++) {
                var b = bricks[c][r];
                if (b.status == 1) {
                    if (x + ballRadius > b.x && x - ballRadius < b.x + brickWidth && y - ballRadius > b.y && y - ballRadius < b.y + brickHeight ||
                        x + ballRadius > b.x && x - ballRadius < b.x + brickWidth && y + ballRadius > b.y && y + ballRadius < b.y + brickHeight) {
                        dy = -dy;
                        b.status = 0;
                        score ++;
                    } else if (b.y > rocketY) rocketShoot = false;
                }
            }
        }
    }

    function drawScore(){
        ctx.font = "16px Arial";
        ctx.fillStyle = "#0095DD";
        ctx.fillText("Score :" + score, 10, 20);
    }

    function drawBricks() {
        for (var c = 0; c < brickColumnCount; c++) {
            for (var r = 0; r < brickRowCount; r++) {
                if (bricks[c][r].status == 1) {
                    var brickX = c * (brickWidth + brickPadding) + brickOffsetLeft;
                    var brickY = r * (brickHeight + brickPadding) + brickOffsetTop;
                    bricks[c][r].x = brickX;  // 충돌 감지를 위한 값
                    bricks[c][r].y = brickY;
                    ctx.beginPath();
                    ctx.rect(brickX, brickY, brickWidth, brickHeight);
                    ctx.fillStyle = "rgb(0, 200, 0)";
                    ctx.fill();
                    ctx.closePath();
                }
            }
        }
    }

    function drawPaddle() {
        ctx.beginPath();
        ctx.rect(paddleX, paddleY, paddleWidth, paddleHeight);
        ctx.fillStyle = "#0095DD";
        ctx.fill();
        ctx.closePath();
    }

    function drawBall() {
        ctx.beginPath();
        ctx.arc(x, y, ballRadius, 0, Math.PI * 2);
        ctx.fillStyle = "rgb(200, 0, 0)";
        ctx.fill();
        ctx.closePath();
    }

    function draw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        drawBricks();
        drawBall();
        drawPaddle();
        drawScore();
        collisionDetection();

        if(score === brickColumnCount * brickRowCount){
            alert("You win!");
            dx = dy = 0;
            document.location.reload();
        }

        if (y + dy > canvas.width - ballRadius) {
            alert("Game over");
            dx = 0;
            dy = 0;
            document.location.reload();
        }

        // 벽 충돌 시
        if (x + dx < ballRadius || x + dx > canvas.width - ballRadius) dx = - dx;
        else if (y + dy < ballRadius) dy = - dy;


        // 패드 충돌 시
        if(y + dy > paddleY){
            if(x > paddleX - ballRadius && x < paddleX + paddleWidth + ballRadius){
                dy = -dy;
            // 움직이는 패들과 충돌 시 x방향 변환
                if(rightPressed == true && Math.sign(dx) == -1) dx = -dx;
                else if (leftPressed == true && Math.sign(dx) == 1) dx = -dx;
            
            }
        }
          
        // 버튼감지 후 패들의 움직임
        if (rightPressed && paddleX < canvas.width - paddleWidth) paddleX += 7;
        else if (leftPressed && paddleX > 0) paddleX -= 7;

        if(rocketShoot) {
            drawRocket();
            rocketY += rocketSpeed;
        } else paddleY = canvas.height - paddleHeight - 10;
     
        x += dx;
        y += dy;
    }

    setInterval(draw, speed);
}

window.onload = () => {
    interact();
}