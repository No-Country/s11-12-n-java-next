"use client";

import { ChangeEvent, Dispatch, SetStateAction, useState } from "react";
import { Input, Select, SelectItem } from "@nextui-org/react";

import TextIcon from "@/assets/icons/text.svg"
import SimpleIcon from "@/assets/icons/circle-outline.svg"
import MultipleIcon from "@/assets/icons/multiple-select.svg"
import StarIcon from "@/assets/icons/star.svg"
import DateIcon from "@/assets/icons/.svg"
import NewFormLayout from "../newForm/NewFormLayout";
import Image from "next/image";

export default function NewQuestion({
  questionTitle,
  setQuestionTitle,
  setQuestionType,
}: {
  questionTitle: string;
  setQuestionTitle: Dispatch<SetStateAction<string>>;
  setQuestionType: Dispatch<SetStateAction<string>>;
}) {
  const [value, setValue] = useState<Set<string>>(new Set([]));

  const handleSelectionChange = (e: ChangeEvent<HTMLSelectElement>) => {
    console.log(value)
    setValue(new Set([e.target.value]))
    setQuestionType(Array.from(value.values())[0]);
  };

  const items = [
    {
      label: "Texto",
      value: "text",
      img: TextIcon,
      alt: "Icono de una figura texto"
    },
    {
      label: "Selección simple",
      value: "simple",
      img: SimpleIcon,
      alt: ""
    },
    {
      label: "Selección múltiple",
      value: "multiple",
      img: MultipleIcon,
      alt: ""
    },
    {
      label: "Calificación de estrellas",
      value: "stars",
      img: StarIcon,
      alt: ""
    },
    {
      label: "Fecha",
      value: "date",
      img: "",
      alt: ""
    },
  ];

  return (
    <NewFormLayout>
      <label className="text-primary text-lg">Escribe tu nueva pregunta</label>
      <div className="flex flex-col gap-4">
        <Input
          value={questionTitle}
          onChange={(e) => setQuestionTitle(e.target.value)}
        />
        <Select
          selectedKeys={value}
          placeholder="Select a type of question"
          isRequired
          onChange={handleSelectionChange}
          size="sm"
        >
          {items.map((item, i) => (
            <SelectItem
              startContent={<Image src={item.img} alt={item.alt} width={10} height={10} />}
              className="p-2 hover:bg-slate-100 transition-colors"
              key={item.value}
              value={item.value}
            >
              {item.label}
            </SelectItem>
          ))}
        </Select>
        <p className="text-small text-default-500">Selected: {value}</p>
      </div>
    </NewFormLayout>
  );
}
