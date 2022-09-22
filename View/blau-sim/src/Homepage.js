import axios from 'axios';
import {useState} from "react";

function Homepage() {

    const [data, setData] = useState([])

    async function simOnce() {
        try {
            const response = await axios.get('http://localhost:8080/teams/sim');
            setData(response.data)
        } catch (error) {
            console.error(error);
        }
    }
    async function simOnceElo() {
            try {
                const response = await axios.get('http://localhost:8080/teams/sim-elo');
                setData(response.data)
            } catch (error) {
                console.error(error);
            }
        }

    return (<>
            <button className={"bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"} onClick={simOnce}>Simulate 1x</button>
            <button className={"bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"} onClick={simOnceElo}>Simulate 1x (Elo)</button>

            <div className="flex flex-col items-center">
            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div className="py-4 inline-block w-full sm:px-6 lg:px-8">
                    <div className="overflow-hidden">
                        <table className="w-full text-center">
                            <thead className="border-b bg-gray-800">
                            <tr>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    #
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Team
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Games
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Win
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Lose
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Draw
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Goals+
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Goals-
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Goal+/-
                                </th>
                                <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                    Points
                                </th>
                            </tr>
                            </thead >
                            <tbody>
                            {data.map((teams,index)=>{
                                return(
                                    <>
                                        <tr className="bg-white border-b">
                                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index+1}</td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.teamName}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.games}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.wins}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.loses}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.draws}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.goalsScored}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.goalsConceded}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.goalsScored - teams.goalsConceded}
                                            </td>
                                            <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                {teams.points}
                                            </td>
                                        </tr>
                                    </>

                                    )

                            })}

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </>
        )
}

export default Homepage
