import { loginService, registerService } from "@/services/auth.service";
import { useSessionStore } from "@/store/sessionStore";

export default function useSession() {
  const { session, setSession } = useSessionStore();

  const handleRegister = async (registerData: RegisterData) => {
    const res = await registerService(registerData);
    res.resolved && setSession(res.payload);
    console.log(res);
    return res;
  };

  const handleLogin = async (passport: Passport) => {
    const res = await loginService(passport);
    console.log(res.payload);
    res.resolved && setSession(res.payload);
    console.log(res);
    return res;
  };

  return {
    session,
    handleRegister,
    handleLogin,
  };
}
