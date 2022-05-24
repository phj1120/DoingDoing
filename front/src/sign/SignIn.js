import {useEffect} from "react"
import axios from "axios";
import {useNavigate} from "react-router-dom"

function SignIn(){

    const navigate = useNavigate();
    
    //로그인 버튼 클릭 시 계정 확인 후 로그인 처리
    const logIn = () =>{
        /*
        axios.post("api/auth/signIn",{
            userID:"사용자아이디",
            password:"비밀번호",
        }).then((response)=>{
            변수 = response.jwt;
            변수2 = response.result;
        }).catch(error =>{
            alert("fail");
        })
        */
        navigate(`/schedule`);
    }

    //회원가입 버튼 클릭 시 회원가입페이지로 이동
    const goToSignUp = () =>{
        navigate(`/auth/signUp`);
    }
    //useEffect();

    const goTOFindPassword = () =>{
        navigate(`/auth/findPassword`);
    }

    return(
        <div>
            <p>아이디: <input type="text" placeholder="아이디"></input></p>
            <p>비밀번호: <input type="password" placeholder="비밀번호"></input></p>
            <input type="submit" onClick={logIn} value="로그인"></input>
            <button onClick={goToSignUp}>회원가입</button>
            <a onClick={goTOFindPassword}>비밀번호 찾기</a>
        </div>
    )
}

export default SignIn;