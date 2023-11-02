import PendingQuizQuestion from "@/components/cards/PendingQuizQuestion";

export default function QuizzDetail() {
  const data = [
    {
      id: 1,
      question: "Es responsable dentro del trabajo?",
      status: "DONE",
    },
    {
      id: 2,
      question: "Es participativo?",
      status: "DONE",
    },
    {
      id: 3,
      question: "Sabe trabajar en grupo?",
      status: "PENDING",
    },
    {
      id: 4,
      question: "Es organizado con sus tareas?",
      status: "PENDING",
    },
    {
      id: 5,
      question: "Describa cuales son sus fortalezas",
      status: "PENDING",
    },
    {
      id: 6,
      question: "Entregó a tiempo sus tareas?",
      status: "PENDING",
    },
  ];
  return (
    <div className="flex flex-col gap-5 mt-5 w-full">
      {data.map((question) => (
        <PendingQuizQuestion key={question.id} question={question} />
      ))}
    </div>
  );
}
