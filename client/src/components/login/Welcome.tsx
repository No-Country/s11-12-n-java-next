'use client';
import Image from "next/image";
import logo from '@/assets/images/logo.svg'
import Button from "../ui/button/Button";
import { useRouter } from "next/navigation";

export default function SignIn() {

    const router = useRouter()

    const handleRegister = () => {
        router.push('/register')
    }

    const handleLogin = () => {
        router.push('/login')
    }

    return (
        <div className="flex flex-col gap-28 w-full h-screen p-3 items-center">
            <div className="w-full flex flex-col items-center">
                <Image
                    src={logo}
                    alt="Imagen"
                    width={284}
                    height={319}
                    className="m-0 p-0"
                />
                <p className="text-2xl font-light text-center px-9">Tu nueva forma de crear formularios</p>
            </div>
            <div className="w-full flex flex-col gap-6">

                <Button
                    className="w-full"
                    size="md"
                    color="secondary"
                    onClick={() => handleRegister()}
                >
                    Únete ahora
                </Button>

                <div className="w-full flex flex-col gap-4">
                    <span
                        className="text-primary font-bold text-sm"
                    >
                        ¿Ya eres usuario?
                    </span>
                    <Button
                        className="w-full"
                        size="md"
                        onClick={() => handleLogin()}
                    >
                        Iniciar sesión
                    </Button>
                </div>
            </div>
        </div>
    );
};
