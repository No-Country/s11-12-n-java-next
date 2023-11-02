import { Card, CardBody } from "@nextui-org/react";
import Image from "next/image";

import ToolsIcon from "@/assets/icons/tools.svg";
import FinishedIcon from "@/assets/icons/plane-paper.svg";
import ClosedIcon from "@/assets/icons/finished.svg";
import Link from "next/link";

const selectCardByState = ({ state }: { state: string }) => {
  if (state === "En construcción")
    return <Image src={ToolsIcon} alt="Un icono de dos herramientas" />;
  if (state === "Publicados")
    return (
      <Image
        src={FinishedIcon}
        alt="Un icono de dos herramientas"
        width={53}
        height={53}
      />
    );
  if (state === "Cerrados")
    return (
      <Image
        src={ClosedIcon}
        alt="Un icono de dos herramientas"
        width={53}
        height={53}
      />
    );
};

export default function TeamCard({
  teamId,
  organizationName,
  teamName,
  state,
}: {
  teamId: string;
  organizationName: string;
  teamName: string;
  state: string;
}) {
  return (
    <Card
      className="h-24 bg-white rounded-3xl border-3 border-indigo-500 text-teal-700 leading-none w-full"
      shadow="sm"
      isPressable
      as={Link}
      href={`/quizz/${teamId}`}
    >
      <CardBody className="flex flex-row items-center p-4">
        <div>
          <small className="text-primary text-lg font-black">
            {organizationName}
          </small>
          <h3 className="text-primary text-lg">
            <strong>{teamName}</strong>
          </h3>
        </div>
        <div className="ml-auto w-12 h-12">{selectCardByState({ state })}</div>
      </CardBody>
    </Card>
  );
}
