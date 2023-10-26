import React from "react";

export default function AnswerList({ params }: { params: { email: string } }) {
  return (
    <div className="text-teal-700 text-xl flex flex-col items-center">
      <h2>No Country Cohorte s11-12 A</h2>
      <h2 className="font-black">{params.email}</h2>
    </div>
  );
}
