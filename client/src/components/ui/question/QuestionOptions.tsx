import { Input } from "@nextui-org/react";
import Button from "../button/Button";
import NewFormLayout from "../newForm/NewFormLayout";

export default function QUestionOptions() {
  return (
    <NewFormLayout subject="NoCountry - Cohorte s11-12">
        <div className="mt-6 flex flex-col gap-6">
          <label>1. ¿En qué actividades participó?</label>
          <div className="flex flex-col gap-1">
          <small className="text-slate-500">Ingrese las opciones separadas por punto y coma</small>
          <Input />
          <small className="text-slate-500 self-end">Cantidad de opciones (4)</small>
          </div>
      </div>
        
      <Button className="mt-10 mx-auto w-full" type="submit" size="md">Guardar y continuar</Button>
    </NewFormLayout>
  )
}