import {
    Wave
} from './wave.js';

class App {
    constructor() {
        this.canvas = document.createElement('canvas');
        this.ctx = this.canvas.getContext('2d');
        document.body.appendChild(this.canvas);

        this.wave = new Wave();

        window.addEventListener('resize', this.resize.bind(this), false);
        this.resize();

        requestAnimationFrame(this.animate.bind(this));
    }

    resize(){
        this.stageWidth = document.body.clientWidth;
        this.stageHeihgt = document.body.clientHeight;

        this.canvas.width = this.stageWidth *2;
        this.canvas.height = this.stageHeihgt *2;
        this.ctx.scale(2, 2);

        this.wave.resize(this.stageWidth, this.stageHeihgt);
    }

    animate(t) {
        this.ctx.clearRect(0, 0, this.stageWidth, this.stageHeihgt);
        
        this.wave.draw(this.ctx);
        
        requestAnimationFrame(this.animate.bind(this));
    }
}

window.onload = () => {
    new App();
};