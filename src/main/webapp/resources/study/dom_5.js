const d1 = document.getElementById('d1');
const d2 = document.getElementById('d2');
const d3 = document.getElementById('d3');
const d4 = document.getElementById('d4');
const d5 = document.getElementById('d5');
const sp = document.getElementById('sp');

d2.addEventListener('focus',function(){
    console.log('입력 준비');
})

d2.addEventListener('blur',function(){
    console.log('blur 발생');
})


//d1 입력하고 나왔을 때 글자의 길이가 3글자 이하라면 d1 강제로 다시 입력 대기 상태
d1.addEventListener('blur', function(){
    if(d1.value.length<=3){
        d1.focus();
    }
})

d3.addEventListener('change', function(){
    console.log('change 발생');
})

d5.addEventListener('change', function(){
    console.log('select가 변경');
})

d4.addEventListener('keyup', function(){
    console.log('keyup 실행');
    sp.innerHTML=d4.value.length*1000;
})
  
