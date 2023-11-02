import { Card, CardBody } from "@nextui-org/react";
import Image from "next/image";

import ToolsIcon from "@/assets/icons/tools.svg";
import FinishedIcon from "@/assets/icons/plane-paper.svg";
import ClosedIcon from "@/assets/icons/finished.svg";
import Link from "next/link";

const selectCardByState = ({ state }: { state: string }) => {
  if (state === "En construcción")
    return (
      <Image
        src={ToolsIcon}
        alt="Un icono de dos herramientas"
        width={53}
        height={53}
      />
    );
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
      className="border-1 bg-transparent border-[#6979F8]"
      isPressable
      as={Link}
      href={`/quizz/${teamId}`}
    >
      <div className="flex justify-between">
        <CardBody>
          <small className="text-primary">{organizationName}</small>
          <h3 className="text-primary text-lg">
            <strong>{teamName}</strong>
          </h3>
        </CardBody>
        {selectCardByState({ state })}
      </div>
    </Card>
  );
}
