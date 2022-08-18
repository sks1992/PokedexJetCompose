package sk.sandeep.pokedexapp.repository

import dagger.hilt.android.scopes.ActivityScoped
import sk.sandeep.pokedexapp.data.remote.PokeApi
import sk.sandeep.pokedexapp.data.remote.responses.Pokemon
import sk.sandeep.pokedexapp.data.remote.responses.PokemonList
import sk.sandeep.pokedexapp.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An Error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("")
        }
        return Resource.Success(response)
    }
}