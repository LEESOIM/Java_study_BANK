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