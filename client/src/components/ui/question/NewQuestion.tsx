"use client"

import { Accordion, AccordionItem, Input } from "@nextui-org/react";
import NewFormLayout from "../newForm/NewFormLayout";
import Button from "../button/Button";
import Link from "next/link";

export default function NewQuestion() {
  const items = [
    "Si / No",
    "Selección simple",
    "Selección múltiple",
    "Calificación de estrellas",
    "Fecha",
  ];

  return (
    <NewFormLayout>
      <h3 className="text-primary text-lg font-bold">
        Escribe tu nueva pregunta
      </h3>
      <div className="flex flex-col gap-4">
        <Input />

        <Accordion variant="bordered" selectionMode="multiple">
          <AccordionItem
            aria-label="Seleccione tipo de respuesta"
            title="Seleccione tipo de respuesta"
          >
            {items.map((item, i) => (
              <Link key={i} href="#"><p className="border-t-1 p-2 hover:bg-slate-100 transition-colors">{item}</p></Link>
            ))}
          </AccordionItem>
        </Accordion>

        <Button className="mt-10 mx-auto font-bold" size="xl">
          Guardar y continuar
        </Button>
      </div>
    </NewFormLayout>
  );
}
