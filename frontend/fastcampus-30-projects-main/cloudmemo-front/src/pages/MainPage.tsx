import axios from "axios";
import { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Box from "../components/Box";
import Button from "../components/Button";
import Editor from "../components/Editor";
import Flex from "../components/Flex";
import Memo from "../interfaces/Memo";

const MainPage = () => {
	const navigate = useNavigate()

	const [edit, setEdit] = useState("")
	const [memoList, setMemoList] = useState<Memo[]>([])

	useEffect(() => {
		(async () => {
			const { data: { rs } } = await axios.get("/tmp")

			setEdit(rs)
		})()

		loadMemo()
	}, [])

	useEffect(() => {
		if (edit.length > 0)
			axios.post("/tmp", {
				content: edit
			})
	}, [edit])

	const loadMemo = useCallback(async () => {
		const { data } = await axios.get<Memo[]>('/')

		setMemoList(data)
	}, [setMemoList])

	const handleSubmit = useCallback(async () => {
		if (edit.replace(/<[/\w\s"=-]*>/gi, "").length === 0) {
			alert("메모가 비어있습니다.")
			return;
		}

		try {
			const { data } = await axios.post('/', {
				content: edit
			})

			setMemoList(prev => [...prev, data])

			setEdit("")
			alert("제출 완료!")
		}
		catch (e) {
			alert("저장 실패")
		}
	}, [edit])

	return <Box p="16px">
		<h1>
			클라우드 메모장
		</h1>
		<Editor value={edit} onChange={setEdit} />
		<Flex justifyContent={"flex-end"} style={{
			gap: "8px"
		}}>
			<Button mt="8px" onClick={handleSubmit}>
				제출
			</Button>
			<Button mt="8px" onClick={() => navigate("/manager")}>
				관리자
			</Button>
		</Flex>
		{
			memoList.map((value) =>
				<Flex
					style={{
						cursor: "pointer"
					}}
					onClick={() => navigate('/' + value.id)}
					border={"#ccc solid 1px"}
					my="8px"
					p="12px"
					key={value.created_at}
					flexDirection="column"
				>
					<Box
						className="memo-content"
						dangerouslySetInnerHTML={{
							__html: value.content
						}}
					/>
					<Box
						textAlign={"right"}
						fontSize={"12px"} color="#555">
						생성: {new Date(value.created_at).toLocaleString()}
					</Box>
					{
						value.updated_at &&
						<Box
							textAlign={"right"}
							fontSize={"12px"} color="#555">
							수정: {new Date(value.updated_at).toLocaleString()}
						</Box>
					}
				</Flex>
			)
		}
	</Box>
}

export default MainPage;