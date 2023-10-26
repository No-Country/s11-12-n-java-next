import PendingQuizCard from "@/components/cards/PendingQuizCard";

function FormsView() {
  const data = [
    {
      id: 1,
      title: "No Country Cohorte s11-12 (A)",
      percent: "80%",
    },
    {
      id: 2,
      title: "No Country Cohorte s11-12 (B)",
      percent: "60%",
    },
    {
      id: 3,
      title: "No Country Cohorte s11-12 (C)",
      percent: "95%",
    },
  ];

  return (
    <div className="text-teal-700 text-xl flex flex-col">
      <h2>Listado de</h2>
      <span className="font-bold">CUESTIONARIOS PENDIENTES</span>
      <div className="flex flex-col gap-5 mt-9 w-full">
        {data.map((item) => (
          <PendingQuizCard key={item.id} pendingQuiz={item} />
        ))}
      </div>
    </div>
  );
}
export default FormsView;
