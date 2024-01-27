"use client";

import { useState } from "react";
import {
  Configuration,
  ExampleControllerApi,
} from "@/lib/generated-server-api";

const configuration = new Configuration({
  basePath: "http://localhost:8080",
});
const api = new ExampleControllerApi(configuration);

export default function Button() {
  const [data, setData] = useState("");

  const handleClick = async () => {
    try {
      const fetchedData = (await api.helloWorld()).message;
      setData(fetchedData);
    } catch (err: any) {
      console.log(err.message);
    }
  };

  return (
    <div className={"border border-amber-500"}>
      <p>This is a client component!</p>
      <button
        className={
          "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        }
        type={"submit"}
        onClick={handleClick}
      >
        Click me to fetch data!
      </button>
      <p>The data is: {data}</p>
    </div>
  );
}
