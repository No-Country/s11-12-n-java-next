"use client";

import { useState } from "react";
import { Input } from "@nextui-org/react";

import useForms from "@/hooks/useForms";

import NewFormLayout from "./NewFormLayout";
import FormItem from "./FormItem";
import Button from "../ui/button/Button";
import NewQuestion from "../question/NewQuestion";

const typeOfAnswer = (type: string) => {
  if (type === "simple") {
    return (
      <div className="flex justify-center items-center gap-4">
        <div className="flex justify-center items-center gap-4">
          <input type="checkbox" /> <p>Sí</p>
        </div>
        <div className="flex justify-center items-center gap-4">
          <input type="checkbox" /> <p>No</p>
        </div>
      </div>
    );
  }
};

export default function NewForm() {
  const {handleCreateForms} = useForms()

  const [form, setForm] = useState<FormSchema>({
    title: "",
    description: ""
  });

  const [questions, setQuestions] = useState<Question[]>([]);
  const [title, setTitle] = useState("");
  const [desc, setDesc] = useState("");
  const [questionTitle, setQuestionTitle] = useState("");
  const [questionType, setQuestionType] = useState("");

  const [modal, setModal] = useState(false)

  const userForm = () => {
    setForm({
      title: title,
      description: desc,
      questions: [...questions]
    })

    // pasar el token para hacer la req
    handleCreateForms(form) 
    // mandar los datos a la ruta /forms 
    // Mostrar un mensaje toast con un mensaje de exito
    // redireccionarme a la pagina quizz/[id]
  };

  const userQuestions = (obj: Question) => {
    return setQuestions([...questions, obj]);
  };

  const formData = {
    title,
    desc,
    question: questionTitle,
    questionType,
  };

  const handleAdd = () => {
    if (!title) alert("Debes agregar un titulo");
    if (!desc) alert("Debes agregar una descripcion");
    if (!questionTitle) alert("Debes agrear un texto de consigna");
    if (!questionType) alert("Debes seleccionar un tipo de consigna");
    // si questionType es multiple, mostrar modal para agregar las opciones

    // si hay un error, no puede proceder a lo de abajo
    // y mostrat un mensaje toast sobre el error

    userQuestions(formData);
    setQuestionTitle("");
    setQuestionType("");
  };

  return (
    <NewFormLayout subject="Datos de cuestionarios que desea crear">
      <FormItem
        text={title}
        setText={setTitle}
        subject="¿Cómo quieres llamarle a tu nuevo formulario?"
      />
      <FormItem
        text={desc}
        setText={setDesc}
        subject="Describe de que se tratará"
      />
      <div className="my-4 py-[.7px] bg-slate-400 rounded-full w-full"></div>
      <NewQuestion
        questionTitle={questionTitle}
        setQuestionTitle={setQuestionTitle}
        setQuestionType={setQuestionType}
      />
      {modal ? <dialog className="p-2 aboslute top-0 right-0 z-10 mx-auto">
          <p>Inserta las opciones</p>
          <Input type="text" />
        </dialog> : null}

      <Button
        onPress={handleAdd}
        className="mx-auto"
        isIconOnly
        size="lg"
        radius="full"
        color="primary"
        arial-label="Generate a new question"
      >
        +
      </Button>

      {JSON.stringify(questions)}
      {/* Mostrat una lista de compenentes en circulo (preguntas) a medida que se van creando las preguntas */}
      {JSON.stringify(form)}      
        <Button onPress={userForm} className="mt-8 w-full py-5" size="lg">
          Guardar y continuar
        </Button>
    </NewFormLayout>
  );
}
