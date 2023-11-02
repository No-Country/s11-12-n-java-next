export interface TeamMember {
  id: string;
  name: string;
  lastname: string;
  email: string;
}

interface Team {
  id: string;
  organizationName: string;
  teamName: string;
  state: string;
  teamMembers: TeamMember[];
}

interface FormState {
  id: string;
  state: string;
}

export const formState: FormState[] = [
  {
    id: crypto.randomUUID(),
    state: "En construcción",
  },
  {
    id: crypto.randomUUID(),
    state: "Publicados",
  },
  {
    id: crypto.randomUUID(),
    state: "Cerrados",
  },
];

const teamMembers1: TeamMember[] = [
  {
    id: crypto.randomUUID(),
    name: "María",
    lastname: "Rodríguez",
    email: "mariarodriguez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Juan",
    lastname: "Pérez",
    email: "juanperez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Laura",
    lastname: "González",
    email: "lauragonzalez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Carlos",
    lastname: "López",
    email: "carloslopez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Ana",
    lastname: "Martínez",
    email: "anamartinez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Javier",
    lastname: "Sánchez",
    email: "javiersanchez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Isabel",
    lastname: "García",
    email: "isabelgarcia@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Daniel",
    lastname: "Fernández",
    email: "danielfernzandez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Paula",
    lastname: "Torres",
    email: "paulatorres@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Alejandro",
    lastname: "Ramírez",
    email: "alejandroramirez@mail.com",
  },
];

const teamMembers2: TeamMember[] = [
  {
    id: crypto.randomUUID(),
    name: "Luis",
    lastname: "Álvarez",
    email: "luisalvarez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Marta",
    lastname: "Jiménez",
    email: "martajimenez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Roberto",
    lastname: "Morales",
    email: "lauragonzalez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Andrea",
    lastname: "Castro",
    email: "andreacastro@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Sergio",
    lastname: "Herrera",
    email: "sergioherrera@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Natalia",
    lastname: "Ríos",
    email: "nataliarios@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "David",
    lastname: "Ortiz",
    email: "davidortiz@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Juan Carlos",
    lastname: "López",
    email: "jclopez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Patricia",
    lastname: "Fernández",
    email: "patriciahernandez@mail.com",
  },
  {
    id: crypto.randomUUID(),
    name: "Alejandra",
    lastname: "Soto",
    email: "alejandrasoto@mail.com",
  },
];

export const allTeams: Team[] = [
  {
    id: formState[0].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-01",
    state: "En construcción",
    teamMembers: teamMembers1,
  },
  {
    id: formState[1].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-03",
    state: "Publicados",
    teamMembers: teamMembers1,
  },
  {
    id: formState[2].id,
    organizationName: "NoCountry",
    teamName: "Cohorte s11-05",
    state: "Cerrados",
    teamMembers: teamMembers1,
  },
];
