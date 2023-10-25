import Image from "next/image";
import logo from "@/assets/images/logo.svg";
import Button from "../ui/button/Button";
import Link from "next/link";

export default function Welcome() {
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
        <p className="text-2xl font-light text-center px-9">
          Tu nueva forma de crear formularios
        </p>
      </div>
      <div className="w-full flex flex-col gap-6">
        <Button
          as={Link}
          href="/register"
          className="w-full"
          size="xl"
          color="secondary"
        >
          Únete ahora
        </Button>

        <div className="w-full flex flex-col gap-4">
          <span className="text-primary font-bold text-sm">
            ¿Ya eres usuario?
          </span>
          <Button as={Link} href="/login" className="w-full" size="xl">
            Iniciar sesión
          </Button>
        </div>
      </div>
    </div>
  );
}
