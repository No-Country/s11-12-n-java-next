import PendingQuizCardUser from "@/components/cards/PendingQuizCardUser";

function FormView({ params }: { params: { id: string } }) {
  const data = [
    {
      id: 1,
      userName: "Valesca Atenas",
      email: "valescaatenas@gmail.com",
      pending: false,
    },
    {
      id: 2,
      userName: "Alan tello",
      email: "Alantello@gmail.com",
      pending: true,
    },
    {
      id: 3,
      userName: "Dhessy",
      email: "dhessy@gmail.com",
      pending: true,
    },
    {
      id: 4,
      userName: "Eynar Alvarez",
      email: "eynaralvarez@gmail.com",
      pending: true,
    },
    {
      id: 5,
      userName: "Andres frei",
      email: "andresfrei@gmail.com",
      pending: true,
    },
  ];

  console.log(params.id);

  return (
    <div className="text-teal-700 text-xl flex flex-col items-center">
      <h2 className="font-black">No country Cohorte s11-12A</h2>
      <div className="flex flex-col gap-5 mt-5 w-full">
        {data.map((user) => (
          <PendingQuizCardUser key={user.id} user={user} quizId={params.id} />
        ))}
      </div>
    </div>
  );
}
export default FormView;
