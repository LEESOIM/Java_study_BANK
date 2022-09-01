const remove1 = document.getElementById('remove1');
const remove2 = document.getElementById('remove2');
const d1 = document.getElementById('d1');
const d2 = document.getElementById('d2');

remove1.addEventListener('click', function(){
    d1.remove(); //자기 포함 삭제
})

remove2.addEventListener('click', function(){
    //자식만 삭제
    // d2.removeChild(d2_1); 


    // for(데이터타입 변수명:컬렉션변수명)
    const ch = document.getElementsByClassName('ch');
    const ar = [];
    for(let i=0;i<ch.length;i++){
        ar.push(ch[i].id); //id속성을 배열끝에 하나씩 넣는다
    }
    for(i of ar){
        let d = document.getElementById(i);
        d2.removeChild(d);
    }

    //자식들만 삭제
    // for(let i=1;i<5;i++){ 
    //     const ds = document.getElementById('d2_'+i);
    //     d2.removeChild(ds);
    // }
})