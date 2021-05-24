function draw() {
    var canvas = document.getElementById("canvas");
    if (canvas.getContext) {
      var ctx = canvas.getContext("2d");

      ctx.fillStyle = "rgb(200,0,0)";
      ctx.fillRect (20, 20, 50, 100);

      ctx.fillStyle = "rgb(0, 0, 200, 0.5)";
      // rectangle
      ctx.fillRect (70, 70, 50, 500);
      //ctx.strokeRect(0, 0, 100, 100);
      ctx.clearRect(70, 70, 25, 25);

      ctx.beginPath();  // 경로 초기화
      ctx.moveTo(50, 140);  // pen이동, 시작점(마지막 moveTo 기준)
      ctx.lineTo(150, 60);  // 경로
      ctx.lineTo(250, 140);
      ctx.lineTo(150, 220);
      ctx.closePath();  // 시작점(마지막 moveTo)과 끝 지점 연결
      ctx.stroke(); // fill, stroke
      
      ctx.beginPath();
      ctx.arc(50, 140, 50, 0, Math.PI *2, true);
      ctx.moveTo(250, 140);
      ctx.arc(200, 140, 50, 0, Math.PI, true);
      ctx.lineTo(150, 300);
      ctx.stroke();

      ctx.beginPath();
      ctx.arc(75, 75, 50, 0, Math.PI*2, true);
      ctx.moveTo(105, 75); // 없으면 선 그어짐
      ctx.arc(75, 75, 30, 0, Math.PI, false); // 시계 방향
      ctx.stroke();
    }
  }