import styled from '@emotion/styled';
import Cookies from 'js-cookie';
import React, { useState } from 'react';
import Card from './components/Card';
import Edit from './components/Edit';
import Memo from './interfaces/Memo';
import useMemo from './store/memoStore';


const CardContainer = styled.div`
	display: flex;
	gap: 40px;
	flex-wrap: wrap;
	align-items: center;
`;

const PlusCard = styled.div`
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 48px;
	border: solid 1px #707070;
	width: 80px;
	height: 80px;
	padding-bottom: 8px;
	box-sizing: border-box;
	cursor: pointer;
	margin: 80px;
`;


function App() {
	const [mode, setMode] = useState<'edit' | 'view'>('view')
	const { setSelectedIndex, memoList, clear } = useMemo();

	return (
		<>
			{
				mode === "view" &&
				<CardContainer>
					{
						memoList.map((memo, idx) => <Card
							key={idx}
							onClick={() => {
								setSelectedIndex(idx);
								setMode('edit')
							}}
							title={memo.title} />)
					}
					<PlusCard onClick={() => {
						setSelectedIndex(null);
						setMode("edit");
					}}>+</PlusCard>
					<PlusCard onClick={() => {
						setSelectedIndex(null);
						clear()
					}}>C</PlusCard>
				</CardContainer>
			}
			{
				mode === "edit" && <Edit setMode={setMode} />
			}
		</>
	);
}

export default App;
