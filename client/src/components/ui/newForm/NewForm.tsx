import Link from "next/link";
import Button from "../button/Button";
import FormItem from "./FormItem";
import NewFormLayout from "./NewFormLayout";

export default function NewForm() {
  return (
    <NewFormLayout subject="Datos de cuestionarios que desea crear">
      <FormItem subject="¿Cómo quieres llamarle a tu nuevo formulario?" />
      <FormItem subject="Describe de que se tratará" />
      <Link href={`/quizz/${1}/`}><Button className="mt-8 w-full py-5" type="submit" size="lg">Guardar y continuar</Button></Link>
    </NewFormLayout>
  )
}