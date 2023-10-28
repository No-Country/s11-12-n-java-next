"use client";

import { Card, CardBody } from "@nextui-org/react";
import Link from "next/link";
import PendingIcon from "@/assets/icons/pending.svg";
import DoneIcon from "@/assets/icons/done.svg";
import Image from "next/image";

interface Props {
  user: {
    id: number;
    userName: string;
    email: string;
    status: string;
  };
  quizId: string;
}

export default function PendingQuizCardUser({ user, quizId }: Props) {
  return (
    <Card
      className="w-full h-24 bg-white rounded-3xl border-3 border-indigo-500 text-teal-700 leading-none text-xl"
      shadow="sm"
      isPressable
      as={Link}
      href={`/answer/${quizId}/${user.userName}`}
    >
      <CardBody className="overflow-visible flex flex-row p-4">
        <div className="flex flex-col justify-center">
          <h2 className="font-black">{user.userName}</h2>
          <p className="text-xl font-light m-0">{user.email}</p>
        </div>
        <div className="ml-auto flex w-12 h-12">
          {user.status === "PENDING" ? (
            <Image src={PendingIcon} alt={"Pending Icon"} />
          ) : (
            <Image src={DoneIcon} alt={"Done Icon"} />
          )}
        </div>
      </CardBody>
    </Card>
  );
}
