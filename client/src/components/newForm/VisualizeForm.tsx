import Link from "next/link";
import NewFormLayout from "./NewFormLayout";
import Button from "../ui/button/Button";

export default function VisualizeForm() {
  return (
    <NewFormLayout subject="Visualización del formulario">
      <p className="text-slate-500">No tienes preguntas hechas. Empieza con una.</p>

<Link className="mx-auto" href={`quizz/${1}/question`}><Button isIconOnly size="lg" radius="full"color="primary" arial-label="Generate a new question">+</Button></Link>
    </NewFormLayout>
  )
}