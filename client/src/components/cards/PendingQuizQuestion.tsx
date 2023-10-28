"use client";

import { Card, CardBody } from "@nextui-org/react";
import PendingIcon from "@/assets/icons/pending.svg";
import DoneIcon from "@/assets/icons/done.svg";
import Image from "next/image";

interface Props {
  question: {
    id: number;
    question: string;
    status: string;
  };
}

export default function PendingQuizQuestion({ question }: Props) {
  return (
    <Card
      className="w-full min-h-unit-16 bg-white rounded-3xl border-3 border-indigo-500 text-teal-700 leading-none text-xl"
      shadow="sm"
      isPressable
    >
      <CardBody className="overflow-visible flex flex-row p-4 items-center">
        <p className="text-xl font-light m-0 pr-5">
          <span className="font-black">{question.id}. </span>
          {question.question}
        </p>
        <div className="ml-auto flex w-6 h-6">
          {question.status === "PENDING" ? (
            <Image src={PendingIcon} alt={"Pending Icon"} />
          ) : (
            <Image src={DoneIcon} alt={"Done Icon"} />
          )}
        </div>
      </CardBody>
    </Card>
  );
}
