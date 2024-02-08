"use client";

import {
  Configuration,
  ExampleControllerApi,
} from "@/lib/generated-server-api";
import { useEffect, useState } from "react";

const configuration = new Configuration({
  basePath: "http://localhost:8080",
});
const api = new ExampleControllerApi(configuration);

export default function ClientPage() {
  const [data, setData] = useState("");

  useEffect(() => {
    api.helloWorld().then((value) => setData(value.message));
  });

  const sayHello = () => {
    alert("Hello Simmen!");
  };

  return (
    <>
      <p>{data}</p>
      <button onClick={sayHello}>Hallo Simmen</button>
    </>
  );
}
