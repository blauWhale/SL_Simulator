import axios from 'axios';
import {useEffect, useState} from "react";

function Homepage() {

    const [data, setData] = useState([])
    const [teams, setTeams] = useState([])
    const [eloSortedTeams, setEloSortedTeams] = useState([])
    const [bestPlayers, setBestPlayers] = useState([])
    const [avgRatingTeams, setAvgRatingTeams] = useState([])
    const [team, setTeam] = useState([])

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

    async function simXAmount() {
        try {
            const response = await axios.get('http://localhost:8080/teams/sim/' + 100);
            setData(response.data)
        } catch (error) {
            console.error(error);
        }
    }

    async function selectTeam(team) {
        try {
            const response = await axios.get('http://localhost:8080/team/' + team)
            setTeam(response.data)
        } catch (error) {
            console.error(error);
        }
    }

    async function sortAvgRating() {
        if (teams) {
            setAvgRatingTeams(teams);
            avgRatingTeams.map((team) => {
                let sum = 0
                team.players.map(player => (
                    sum += player.rating.fmRating
                ))
                team.rating.fmRating = (sum / 11).toFixed(1);
            })
            avgRatingTeams.sort((a, b) => (b.rating.fmRating) - (a.rating.fmRating))

        }

    }


    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get('http://localhost:8080/teams')
            setTeams(response.data)
            setEloSortedTeams(response.data)
        }
        fetchData()
            .catch(console.error);
    }, [])

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get('http://localhost:8080/players')
            setBestPlayers(response.data.sort((a, b) => (b.rating.fmRating) - (a.rating.fmRating)))
        }
        fetchData()
            .catch(console.error);
    }, [])

    useEffect(() => {
        sortAvgRating()
            .catch(console.error)
    }, [])


    return (<>
            <button
                className={"bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"}
                onClick={simOnce}>Simulate 1x
            </button>
            <button
                className={"bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"}
                onClick={simXAmount}>Simulate 100x
            </button>
            <button
                className={"bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"}
                onClick={simOnceElo}>Simulate 1x (Elo)
            </button>

            <div className="flex flex-wrap items-start">
                <div
                    className="w-48 text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                    {teams?.map((team) => {
                        return (
                            <>
                                <button aria-current="true" type="button"
                                        className="py-2 px-4 w-full font-medium text-left border-b border-gray-200 cursor-pointer hover:bg-gray-100 hover:text-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-700 focus:text-blue-700 dark:border-gray-600 dark:hover:bg-gray-600 dark:hover:text-white dark:focus:ring-gray-500 dark:focus:text-white"
                                        onClick={() => {
                                            selectTeam(team.id)
                                        }}>
                                    {team.name}
                                </button>
                            </>

                        )
                    })}
                </div>
                <div className="py-4 sm:px-6 lg:px-8">
                    <table className=" text-center">
                        <thead className="border-b bg-gray-800">
                        <div className={"text-white"}>{team?.name}</div>
                        <tr>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                #
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                Player
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                FM Rating
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {team && team.players && team.players.map((player, index) => {
                            return (
                                <>
                                    <tr className="bg-gray-100 border-b">
                                        <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index + 1}</td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {player.name}
                                        </td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {player.rating.fmRating}
                                        </td>
                                    </tr>
                                </>

                            )

                        })}
                        </tbody>
                    </table>
                </div>
                <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-4 inline-block w-full sm:px-6 lg:px-8">
                        <div className="overflow-hidden">
                            <table className="w-full text-center">
                                <thead className="border-b bg-gray-800">
                                <div className={"text-white"}>Sim Table</div>
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
                                </thead>
                                <tbody>
                                {data.map((teams, index) => {
                                    return (
                                        <>
                                            <tr className="bg-gray-100 border-b">
                                                <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index + 1}</td>
                                                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                    {teams.name}
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
                <div className="py-4 sm:px-6 lg:px-8">
                    <table className="w-full text-center">
                        <thead className="border-b bg-gray-800">
                        <div className={"text-white"}>Elo Table</div>
                        <tr>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                #
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                Team
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                Elo Score
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {eloSortedTeams?.sort((a, b) => (b.rating.elo) - (a.rating.elo)).map((teams, index) => {
                            return (
                                <>
                                    <tr className="bg-gray-100 border-b">
                                        <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index + 1}</td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {teams.name}
                                        </td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {teams.rating.elo}
                                        </td>
                                    </tr>
                                </>

                            )

                        })}
                        </tbody>
                    </table>
                </div>
                <div className="py-4 sm:px-6 lg:px-8">
                    <table className="w-full text-center">
                        <thead className="border-b bg-gray-800">
                        <div className={"text-white"}>Avg. Rating Table</div>
                        <tr>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                #
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                Team
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                FM Rating Average
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {teams?.map((team, index) => {
                            return (
                                <>
                                    <tr className="bg-gray-100 border-b">
                                        <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index + 1}</td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {team.name}
                                        </td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {team.rating.fmRating}
                                        </td>
                                    </tr>
                                </>
                            )

                        })}
                        </tbody>
                    </table>
                </div>
                <div className="py-4 sm:px-6 lg:px-8">
                    <table className="w-full text-center">
                        <thead className="border-b bg-gray-800">
                        <div className={"text-white"}>Player Table</div>
                        <tr>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                #
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                Player
                            </th>
                            <th scope="col" className="text-sm font-medium text-white px-6 py-4">
                                FM Rating
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {bestPlayers?.map((player, index) => {
                            return (
                                <>
                                    <tr className="bg-gray-100 border-b">
                                        <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{index + 1}</td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {player.name}
                                        </td>
                                        <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                            {player.rating.fmRating}
                                        </td>
                                    </tr>
                                </>

                            )

                        })}
                        </tbody>
                    </table>
                </div>
            </div>

        </>
    )
}

export default Homepage
