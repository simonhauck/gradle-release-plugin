import {
  Configuration,
  ExampleControllerApi,
} from "@/lib/generated-server-api";

const configuration = new Configuration({
  basePath: "http://localhost:8080",
});
const api = new ExampleControllerApi(configuration);

export default async function Test() {
  const data = await api.helloWorld();

  return (
    <>
      <div>Hallo Simmen!</div>
      <div>Ich bins Tobi</div>
      <div>{data.message}</div>
    </>
  );
}
