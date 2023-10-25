import Image from "next/image";
import { Card, CardBody } from "@nextui-org/react";

import LogoIcon from "@/assets/images/logo-white.svg"
import TickIcon from "@/assets/icons/tick.svg"
import LockerIcon from "@/assets/icons/error-locker.svg"

export default function MessageModal({ typeMessage }: { typeMessage: "success" | "error" }) {
  return (
    typeMessage === "success" ?
    <Card className="bg-primary text-primary-foreground rounded-[20px] p-2">
      <CardBody className=" flex flex-col items-center gap-5">
        <h3 className="font-bold text-4xl text-white">¡Buen trabajo!</h3>
        <Image src={TickIcon} alt="Icono mostrando una ilustración de un tick" width="100" height="100" />
        <p className="font-bold text-white w-[25ch] text-center">Ya eres parte del team</p>
        <Image src={LogoIcon ?? ""} alt="Logo de la página en blanco" width="100" height="100" />
      </CardBody>
    </Card>
    : <Card className="bg-primary text-white rounded-[20px] p-2">
      <CardBody className=" flex flex-col items-center gap-5">
        <Image src={LockerIcon ?? ""} alt="Icono de un llavero cerrado" width="100" height="100" />
        <p className="font-bold text-white w-[25ch] text-center">El usuario o contraseña no son válidos. Intente nuevamente.</p>
      </CardBody>
    </Card>
  )
}