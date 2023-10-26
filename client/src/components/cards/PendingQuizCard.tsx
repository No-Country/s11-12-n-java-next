"use client";

import { Card, CardBody } from "@nextui-org/react";
import Link from "next/link";

interface Props {
  pendingQuiz: {
    id: number;
    title: string;
    percent: string;
  };
}

export default function PendingQuizCard({ pendingQuiz }: Props) {
  return (
    <Card
      className="w-full h-32 bg-white rounded-3xl border-3 border-indigo-500 text-teal-700 leading-none"
      shadow="sm"
      isPressable
      as={Link}
      href={`/answer/${pendingQuiz.id}`}
    >
      <CardBody className="overflow-visible flex flex-col justify-around">
        <h2 className="font-black text-[1.375rem]">{pendingQuiz.title}</h2>
        <div className="flex">
          <p className="text-xl font-light">
            Cuestionarios por responder{"  "}
            <span className="text-teal-700 font-black text-3xl">
              {pendingQuiz.percent}
            </span>
          </p>
        </div>
      </CardBody>
    </Card>
  );
}
