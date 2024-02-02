import {
  Configuration,
  ExampleControllerApi,
} from "@/lib/generated-server-api";

import Button from "@/components/Button/button";

const configuration = new Configuration({
  basePath: "http://localhost:8080",
});
const api = new ExampleControllerApi(configuration);

export default async function Test() {
  const data = await api.helloWorld();

  return (
    <>
      <div className={"border border-red-500 p-5"}>
        <div>Hallo Simmen! This is a server component!</div>
        <div>Ich bins Tobi</div>
        <div>{data.message}</div>
        <Button></Button>
      </div>
    </>
  );
}
