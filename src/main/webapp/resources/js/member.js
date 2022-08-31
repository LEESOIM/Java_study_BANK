function loginCheck(){
    const btn = document.getElementById('btn');
    const frm = document.getElementById('frm');
    const userName = document.getElementById('userName');
    const password = document.getElementById('password');
    const error = document.getElementById('error');

    btn.addEventListener('click',function(){
        console.log('Submit Button Click');
        let i = userName.value;
        let p = password.value;
        console.log(i);
        console.log(i=='');
        console.log(i.length);

        if(i==""){
            error.innerHTML='ID는 필수입니다';
            return;
        }
        if(p==""){
            error.innerHTML='PW는 필수입니다';
            return;
        }
        frm.submit();
        

        // if(i.length>0 && p.length) {
        //     frm.submit();
        // } else {
        //     alert('아이디와 비밀번호는 필수입니다');
        // }
     
    });
}


function check(){
    const all = document.getElementById('all');
    const cb = document.getElementsByClassName('cb');
    const req = document.getElementsByClassName('req');
    const join = document.getElementById('join');
    const frm = document.getElementById('frm');
    
    all.addEventListener('click',function(){
        for(let i=0; i<cb.length; i++){
            cb[i].checked = all.checked;
        }
    })

    for(let i=0; i<cb.length; i++){
        cb[i].addEventListener('click',function(){
            let result=true;
            for(let j=0; j<cb.length; j++){
                if(!cb[j].checked){
                    result=false;
                    break;
                }
            }
            all.checked = result;
        })
    
    }

    join.addEventListener('click',function(){
        let result=true;
        for(let i=0;i<req.length;i++){
            if(!req[i].checked){
                result=false;
                break;
            }
        }
        if(result){
            frm.submit(); //():강제발생
        }else{
            alert('이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.');
        }

        // if(all.checked){
        //     frm.submit(); 
        // }else{
        //     alert('이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.');
        // }
    })

}



//1. ID를 입력하고 나왔을 때 2글자 미만이면 메세지 출력 : ID는 2글자 이상이어야 합니다
//2. PW를 입력할때마다 메세지 출력 : 6글자 이상이어야 합니다
//3. 두번째 PW를 입력하고 나왔을때 첫번째 PW와 비교해서 메세지 출력 : PW가 일치합니다
//4. name, email, phone 입력이 끝난 후 : 최소 1글자 이상이어야 합니다
//5. 모든 조건 일치하면 submit
function joinCheck(){
    const c1 = document.getElementById('c1');
    const c2 = document.getElementById('c2');
    const c3 = document.getElementById('c3');
    const c4 = document.getElementById('c4');
    const c5 = document.getElementById('c5');
    const c6 = document.getElementById('c6');

    const userName = document.getElementById('userName');
    const password = document.getElementById('password');
    const password2 = document.getElementById('password2');
    const myName = document.getElementById('myName');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
  
    const frm = document.getElementById('frm');
    const btn = document.getElementById('btn');
    
    let idCheck=false;
    let pwCheck=false;
    let pw2Check=false;
    let nameCheck=false;
    let emailCheck=false;
    let phoneCheck=false;

    userName.addEventListener('blur', function(){
        if(userName.value.length < 2){
            idCheck=false;
            c1.innerHTML='ID는 2글자 이상이어야 합니다';
        }else{
            idCheck=true;
            c1.innerHTML='';
        }
    })

    password.addEventListener('change',function(){
        password2.value='';
        c3.innerHTML='';
        if(password.value.length < 6){
            pwCheck=false;
            c2.innerHTML='PW는 6글자 이상이어야 합니다';
        }else{
            pwCheck=true;
            c2.innerHTML='';
        }
    })

    password2.addEventListener('blur',function(){
        if(password.value==password2.value){
            pw2Check=true;
            c3.innerHTML='✔';
        }else{
            pw2Check=false;
            c3.innerHTML='PW가 일치하지 않습니다';
        }
    })
    
    myName.addEventListener('blur',function(){
        if(myName.value.length==0){
            nameCheck=false;
            c4.innerHTML='1글자 이상이어야 합니다';
        }else{
            nameCheck=true;
            c4.innerHTML='';
        }
    })

    email.addEventListener('blur',function(){
        if(email.value.length==0){
            emailCheck=false;
            c5.innerHTML='1글자 이상이어야 합니다';
        }else{
            emailCheck=true;
            c5.innerHTML='';
        }
    })

    phone.addEventListener('blur',function(){
        if(phone.value.length==0){
            phoneCheck=false;
            c6.innerHTML='1글자 이상이어야 합니다';
        }else{
            phoneCheck=true;
            c6.innerHTML='';
        }
    })

    btn.addEventListener('click',function(){
        if(idCheck&&pwCheck&&pw2Check&&nameCheck&&emailCheck&&phoneCheck){
            alert('전송');
            // frm.submit;
        }else{
            alert('필수정보를 입력해주세요');
        }
    })
}
