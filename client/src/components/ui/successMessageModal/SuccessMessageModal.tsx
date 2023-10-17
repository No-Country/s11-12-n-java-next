import Image from "next/image";

import Tick from "@/assets/icons/tick.svg"
import LogoWhite from "@/assets/images/logo-white.svg"

export default function SuccessMessageModal() {
  return (
    <div className="flex flex-col items-center gap-3 p-6 bg-[#00676C] rounded-[20px] min-w-[20em] sm:min-w-[18em]">
      <h3 className="font-bold text-4xl text-white">Buen Trabajo</h3>
      <Image src={Tick} alt="icono mostrando una ilustracion de un tick" width="100" height="100" />
      <p className="font-bold text-white">¡Ya eres parte del team!</p>
      <Image src={LogoWhite} alt="Logo de la página" width="100" height="100" />
    </div>
  )
}