const count = document.getElementById('count');
const btn = document.getElementById('btn');
const result = document.getElementById('result');

const d1 = document.getElementById('d1');
const d1_1 = document.getElementById('d1_1');
const d1_1_1 = document.getElementById('d1_1_1');
const google = document.getElementById('google');


//숫자를 입력하고 버튼을 클릭하면 입력된 숫자만큼 div내에 button태그 생성 class="c1"
btn.addEventListener('click', function(){
    for(let i=0;i<count.value;i++){
        
        let b = document.createElement('button'); //<button></button>
        let t = document.createTextNode('CLICK'+i);//CLICK i
        b.appendChild(t); //<button>CLICK i</button>

        let c = document.createAttribute('class');
        c.value="c1";
        b.setAttributeNode(c); //특정한 값을 넣을때
        result.append(b);
    }
})


//클래스명이 c1인 버튼의 컨텐츠를 alert 띄우기

result.addEventListener('click', function(event){ //부모를 클릭하지만 실제로 클릭한 영역(자식)을 찾는다
    if(event.target.className=='c1'){
        alert(event.target.innerHTML);
    }
})




//------------------------------------------------------------------
// 중첩된 엘리먼트중에서 같은 이벤트(click)가 적용되어 있을때
// 버블링 : 자식부터 실행하고 -> 부모로 전파 false(default)
// 캡처링 : 부모부터 실행하고 -> 자식으로 전파 true

d1.addEventListener('click', function(event){
    console.log('d1 클릭');
    console.log(event);
    console.log(event.currentTarget);
    console.log(event.target);

    if(event.target.className=='buttons'){
            console.log("this : ",this);
            alert(event.target.innerHTML);
    }
    
}, false)



google.addEventListener('click', function(event){
    alert('Go Google');
    event.preventDefault(); //Element가 가지고 있는 기본 동작(event, a, submit) 중단
})