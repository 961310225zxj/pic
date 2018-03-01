$(function () {
    var oDiv1 = document.getElementById('div1');
    var oUl = oDiv1.children[0];
    var aLi = oUl.children;
    var speed = 2;

    oUl.innerHTML += oUl.innerHTML;
    oUl.style.width = aLi[0].offsetWidth * aLi.length + "px"; //设置ul的宽度，使它能够容纳所有的li，不至于li换行

    //var timer = setInterval(move, 30);

    function move() {
        //左滚动：如果ul滚动到其宽度的一半时，调整其左边距为0
        if (oUl.offsetLeft < -oUl.offsetWidth / 2) {
            oUl.style.left = "0";
        }

        //右滚动：如果ul滚动距离左边距大于0时，调整其左边距位置为其宽度的一半
        if (oUl.offsetLeft > 0) {
            oUl.style.left = -oUl.offsetWidth / 2 + "px";
        }

        oUl.style.left = oUl.offsetLeft + speed + "px";
    }

    oDiv1.onmouseover = function() {
        //clearInterval(timer);
    };
    oDiv1.onmouseout = function() {
        //timer = setInterval(move, 30);
    };

    var oDiv2 = document.getElementById('div2');
    oDiv2.children[0].onclick = function() {
        speed = -Math.abs(speed);
    };

    oDiv2.children[1].onclick = function() {
        speed = Math.abs(speed);
    };
})
